package org.openhealthtools.mdht.uml.cda.wizards;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.osgi.util.ManifestElement;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginReference;
import org.eclipse.pde.internal.core.project.PDEProject;
import org.eclipse.pde.internal.ui.wizards.IProjectProvider;
import org.eclipse.pde.internal.ui.wizards.plugin.NewProjectCreationOperation;
import org.eclipse.pde.internal.ui.wizards.plugin.PluginFieldData;
import org.eclipse.pde.ui.IFieldData;
import org.eclipse.pde.ui.IPluginContentWizard;
import org.eclipse.pde.ui.templates.PluginReference;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UML22UMLResource;
import org.openhealthtools.mdht.uml.cda.core.profile.CDATemplate;
import org.openhealthtools.mdht.uml.cda.core.profile.CodegenSupport;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;

@SuppressWarnings("restriction")
public class NewCDAModelWizard extends Wizard {

	

	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		return super.getNextPage(page);
	}


	WizardNewProjectCreationPage newProjectPage;
	
	
	NewCDAModelPage newCDATemplatePage;
	
	   public void addPages() {

		   loadCDAModels();
		   
		   newCDATemplatePage = new NewCDAModelPage("MDHT CDA Model","Open Health Tools ",null, cdaDocuments);
		   
		   newCDATemplatePage.setDescription("Creates the CDA Model");
		   
		   newCDATemplatePage.setMessage("Use to create CDA Implementation Guide Model Project");

		   newProjectPage = new WizardNewProjectCreationPage("MDHT CDA Model");
		   
		   newProjectPage.setTitle("Open Health Tools ");
		   
		   newProjectPage.setDescription("Use to create CDA Implementation Guide Model Project");

		

		   addPage(newCDATemplatePage );
		   addPage(newProjectPage);   

	   }
	   

	   
	@Override
	public boolean performFinish() {
		
		
		final String name = newProjectPage.getProjectName();
				
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		
		IWorkspaceRoot root = workspace.getRoot();
		
		final IProject project = root.getProject(name);
		
		try {
			
			project.create(null);
			
			project.open(null);
			
		
			
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		
		IPluginContentWizard contentWizard = new IPluginContentWizard() {

			@Override
			public void addPages() {

			}

			@Override
			public boolean canFinish() {

				return false;
			}

			@Override
			public void createPageControls(Composite pageContainer) {

			}

			@Override
			public void dispose() {

			}

			@Override
			public IWizardContainer getContainer() {

				return null;
			}

			@Override
			public Image getDefaultPageImage() {

				return null;
			}

			@Override
			public IDialogSettings getDialogSettings() {

				return null;
			}

			@Override
			public IWizardPage getNextPage(IWizardPage page) {

				return null;
			}

			@Override
			public IWizardPage getPage(String pageName) {

				return null;
			}

			@Override
			public int getPageCount() {

				return 0;
			}

			@Override
			public IWizardPage[] getPages() {

				return null;
			}

			@Override
			public IWizardPage getPreviousPage(IWizardPage page) {

				return null;
			}

			@Override
			public IWizardPage getStartingPage() {

				return null;
			}

			@Override
			public RGB getTitleBarColor() {

				return null;
			}

			@Override
			public String getWindowTitle() {

				return null;
			}

			@Override
			public boolean isHelpAvailable() {

				return false;
			}

			@Override
			public boolean needsPreviousAndNextButtons() {

				return false;
			}

			@Override
			public boolean needsProgressMonitor() {

				return false;
			}

			@Override
			public boolean performCancel() {

				return false;
			}

			@Override
			public boolean performFinish() {

				return false;
			}

			@Override
			public void setContainer(IWizardContainer wizardContainer) {

			}

			@Override
			public void init(IFieldData data) {

			}

			@Override
			public IPluginReference[] getDependencies(String schemaVersion) {

				// currently simple sort keeps manifest readable - might need to
				// have more complex logic - SWM

				Comparator<IPluginReference> c = new Comparator<IPluginReference>() {

					@Override
					public int compare(IPluginReference arg0, IPluginReference arg1) {
						return arg0.getId().compareTo(arg1.getId());
					}

				};

				List<IPluginReference> list = new ArrayList<IPluginReference>();

				list.addAll(references.values());

				Collections.sort(list, c);

				IPluginReference[] results = new IPluginReference[list.size()];

				list.toArray(results);

				return results;

			}

			@Override
			public String[] getNewFiles() {

				return new String[] { "plugin.properties" };
			}

			@Override
			public boolean performFinish(IProject project, IPluginModelBase model, IProgressMonitor monitor) {

				return false;
			}

		};

		PluginFieldData fPluginData = new PluginFieldData();
		fPluginData.setDoGenerateClass(false);
		fPluginData.setEnableAPITooling(false);
		fPluginData.setClassname(newCDATemplatePage.getModelName());
		fPluginData.setSourceFolderName("src");
		fPluginData.setOutputFolderName("bin");
		fPluginData.setUIPlugin(false);
		fPluginData.setHasBundleStructure(true);
		fPluginData.setTargetVersion("3.5");
		fPluginData.setExecutionEnvironment("J2SE-1.5");

		IProjectProvider fProjectProvider = new IProjectProvider() {

			@Override
			public IProject getProject() {

				return project;
			}

			@Override
			public String getProjectName() {

				return name;
			}

			@Override
			public IPath getLocationPath() {

				return project.getFullPath();
			}

		};

		try {
			
			// Use pde internal functionality to create plugin 
			getContainer().run(false, true, new NewProjectCreationOperation(fPluginData, fProjectProvider, contentWizard));

			createPluginXML(project);

			createManifest(project);

			createFolder(project, "model");

			createUMLModel(project);

			createTransformation(project);

			createPluginProperties(project);

		} catch (InvocationTargetException e) {
			
			e.printStackTrace();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		try {
			project.refreshLocal(IResource.DEPTH_INFINITE, null);
			
		
		} catch (CoreException e) {
			e.printStackTrace();
		}


		return true;
	}

	
	void createUMLModel(IProject project) {

		ResourceSet resourceSet = new ResourceSetImpl();
		try {

			URI niemCoreModelURI = URI.createPlatformPluginURI(Activator.PLUGIN_ID + "/model/example.uml", false);

			PackageableElement niemCoreModel = (PackageableElement) EcoreUtil.getObjectByType(resourceSet.getResource(niemCoreModelURI, true).getContents(),
					UMLPackage.eINSTANCE.getPackageableElement());

			PackageableElement cloneModel = EcoreUtil.copy(niemCoreModel);

			IPath filePath = new Path("model/" + newCDATemplatePage.getModelName().toLowerCase() + ".uml");

			IFile file = PDEProject.getBundleRelativeFile(project, filePath);

			IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace().getRoot();

			String hl7Path = myWorkspaceRoot.getLocation().toOSString() + file.getFullPath().toOSString();

			URI niemModelURI = URI.createFileURI(hl7Path);

			Resource umlResource = UML22UMLResource.Factory.INSTANCE.createResource(niemModelURI);

			umlResource.getContents().add(cloneModel);

			Map<String, String> options = new HashMap<String, String>();

			// Save initial clone model - This is required to allow uml2 stereotypes to actually be applied
			umlResource.save(options);
			
			if (cloneModel instanceof Package) {
				
				Package clonePackage = (Package) cloneModel;
				
				CodegenSupport codegenSupport= (CodegenSupport)clonePackage.applyStereotype(clonePackage.getApplicableStereotype("CDA::CodegenSupport"));
				
				
				codegenSupport.setBase_Namespace(clonePackage);
				
				codegenSupport.setBasePackage("org.openhealthtools.mdht.uml.cda");
//				newCDATemplatePage.getN
//				newCDATemplatePage.get
				codegenSupport.setNsURI("http://www.openhealthtools.org/mdht/uml/cda/"+newCDATemplatePage.getModelName().toLowerCase());
			
				codegenSupport.setNsPrefix(newCDATemplatePage.getModelName().toLowerCase());
				
				codegenSupport.setPackageName(newCDATemplatePage.getModelName().toLowerCase());

				codegenSupport.setPrefix(newCDATemplatePage.getModelName());
	
				clonePackage.setName(newCDATemplatePage.getModelName().toLowerCase());

				Class cdaClass = clonePackage.createOwnedClass(newCDATemplatePage.getCDADocumentName(), false);
				
				CDATemplate template = (CDATemplate)cdaClass.applyStereotype(cdaClass.getApplicableStereotype("CDA::CDATemplate"));

				template.setBase_Class(cdaClass);
					
				template.setTemplateId(newCDATemplatePage.getTemplateId());
				
				template.setAssigningAuthorityName(newCDATemplatePage.getTemplateAssigningAuthority());
				
				Type t = cdaDocuments.get(newCDATemplatePage.getCDADocument());

				if (t instanceof Class) {
					Class documentClass = (Class) t;

					cdaClass.createGeneralization((Classifier) documentClass);

					clonePackage.createPackageImport(documentClass.getNearestPackage());

				}

			}

			umlResource.save(options);

		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	
	

	
	void createTransformation(IProject project) {

		try {

			StringWriter swriter = new StringWriter();
			
			PrintWriter writer = new PrintWriter(swriter);

			writer.println("<?eclipse version=\"3.0\"?>");		
			writer.println("<project name=\"CDA Model Transformation\"  basedir=\".\" default=\"all\">");
			writer.println("<property name=\"cdaPluginPath\" location=\"${basedir}/../org.openhealthtools.mdht.uml.cda\"/>");			
			writer.println("<property name=\"modelName\" value=\""+ newCDATemplatePage.getModelName().toLowerCase() +"\"/>");
			writer.println("<macrodef name=\"convertEcorePaths\">");			
			writer.println("<attribute name=\"filePath\"/>");
			writer.println("<sequential>");
			
			
			
			for (String cdaPackage : cdaPackages.keySet())
			{
				writer.println("<replace file=\"@{filePath}\" token=\"/"+cdaPackage+".uml\" value=\"/"+cdaPackage+"_Ecore.uml\"/>");
			}
			
			
			writer.println("</sequential>");
			writer.println("</macrodef>");

			writer.println("<import file=\"${cdaPluginPath}/transform-common.xml\"/>");
			writer.println("</project>");	
		

			writer.flush();

			swriter.close();

			InputStream is = new ByteArrayInputStream(swriter.toString().getBytes("UTF-8"));

			createFile(project, "transform.xml", is);

		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	
	
	void createPluginProperties(IProject project) {

		try {

			StringWriter swriter = new StringWriter();
			
			PrintWriter writer = new PrintWriter(swriter);

			writer.println("pluginName = "+ newCDATemplatePage.getModelName()+" Model");
			writer.println("providerName = Provider Name Here");

			writer.flush();

			swriter.close();

			InputStream is = new ByteArrayInputStream(swriter.toString().getBytes("UTF-8"));

			createFile(project, "plugin.properties", is);

		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	
	void createPluginXML(IProject project) {

		try {
			
			IFile pluginXml = PDEProject.getPluginXml(project);

			StringWriter swriter = new StringWriter();

			PrintWriter writer = new PrintWriter(swriter);

			writer.println("<?eclipse version=\"3.0\"?>");
			writer.println("");
			writer.println("");
			writer.println("");
			writer.println("");
			writer.println("<plugin>");
			writer.println("        <extension point=\"org.eclipse.emf.ecore.generated_package\">");
			writer.println("                  <package class=\"org.openhealthtools.mdht.uml.cda."+newCDATemplatePage.getModelName().toLowerCase() +"."+newCDATemplatePage.getModelName()+"Package\" genModel=\"model/"+newCDATemplatePage.getModelName().toLowerCase() +".genmodel\" uri=\"http://www.openhealthtools.org/mdht/uml/cda/"+newCDATemplatePage.getModelName().toLowerCase() +"\"/>");
			writer.println("        </extension>");
			writer.println("</plugin>");

			writer.flush();

			swriter.close();

			InputStream is = new ByteArrayInputStream(swriter.toString().getBytes("UTF-8"));

			pluginXml.create(is, true, null);
			
		} catch (CoreException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	
	
	void createManifest(IProject project) {

		try {
			
			IFile manifest = PDEProject.getManifest(project);

			StringWriter swriter = new StringWriter();

			PrintWriter writer = new PrintWriter(swriter);

			writer.println("Bundle-Name: %pluginName");
			writer.println("Bundle-SymbolicName: org.openhealthtools.mdht.uml.cda."+newCDATemplatePage.getModelName().toLowerCase() +";singleton:=true");		
			writer.println("Bundle-Version: 0.7.0.qualifier");

			writer.flush();

			swriter.close();

			InputStream is = new ByteArrayInputStream(swriter.toString().getBytes("UTF-8"));

			manifest.appendContents(is, true, false, null);
			
		} catch (CoreException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	

	void createFolder(IProject project,String name) {
		try {
			IFolder folder = PDEProject.getBundleRelativeFolder(project, new Path(name));
			folder.create(true, false, null);
		} catch (CoreException e) {
			
			e.printStackTrace();
		}
	}

	void createFile(IProject project,String name,InputStream contents) {
		
		try{

			IPath filePath = new Path(name);				
		
			IFile file = PDEProject.getBundleRelativeFile(project, filePath);
			
			file.create(contents, true, null);
		
	} catch (CoreException e) {
		
		e.printStackTrace();
	} 


	}


	
	HashMap<String, Package> cdaPackages = new HashMap<String, Package>();
	
	HashMap<String, Type> cdaDocuments= new HashMap<String, Type>();
	
	HashMap<String,PluginReference> references = new HashMap<String,PluginReference> (); 
	
	
	Type clinicalDocument=null;
	
	
	
	@SuppressWarnings("unchecked")
	void loadCDAModels()
	{
		ResourceSet resourceSet = new ResourceSetImpl();
		
		IExtensionRegistry registry = Platform.getExtensionRegistry();

		// Get all emf ecore plugins
		IExtensionPoint point = registry.getExtensionPoint("org.eclipse.emf.ecore.generated_package");
		
		if (point != null) {
		
			for (IExtension extension : point.getExtensions()) {

				Bundle bundle = Platform.getBundle(extension.getContributor().getName());
				
				if (bundle != null) {

					// Get the uml files with the bundle
					Enumeration<URL> umlFiles = bundle.findEntries("model", "*.uml", true);

					if (umlFiles != null) {


						
						while (umlFiles.hasMoreElements()) {
							
							java.net.URL umlFileURL = (java.net.URL) umlFiles.nextElement();
							
							// filter out cda uml_ecore models 
							if (!umlFileURL.getFile().contains("_Ecore")) {
								
								URI foo = URI.createPlatformPluginURI(extension.getContributor().getName() + umlFileURL.getPath(), false);
								
								PackageableElement foo2 = (PackageableElement) EcoreUtil.getObjectByType(resourceSet.getResource(foo, true).getContents(),UMLPackage.eINSTANCE.getPackageableElement());
								
								if (foo2 instanceof Package) {
									
									Package p = (Package) foo2;
									// bit of hack checking to see if the package is call cda or CDA Profile applied
									if (p.getAppliedProfile("CDA") != null || p.getName().equals("cda")) {
										
										cdaPackages.put(p.getQualifiedName(), p);
										
										// Add model plugin to required bundles
										references.put(bundle.getSymbolicName(),new PluginReference(bundle.getSymbolicName(),null,0));
										
										// Add model plugin required bundles to the plugin
										Object header =  bundle.getHeaders().get(Constants.REQUIRE_BUNDLE);
										System.out.println("Adding dependency " + bundle.getSymbolicName());						
										try {
											for (ManifestElement manifestElement : ManifestElement.parseHeader(Constants.REQUIRE_BUNDLE, (String) header))
											{
												System.out.println(" " + manifestElement.getValue());
												references.put(manifestElement.getValue() ,new PluginReference(manifestElement.getValue(),null,0));
											}
										} catch (BundleException e1) {
											
											e1.printStackTrace();
										}
									}
								}

							}
						}
					}

				}
			}
		}

		
	Package cdaPackage = cdaPackages.get("cda");
	
	// make sure the package is available
	if (cdaPackage != null)
	{
		clinicalDocument=	cdaPackage.getOwnedType("ClinicalDocument");
		for (Package ps : cdaPackages.values())
		{
			
			for (Type type : ps.getOwnedTypes())
			{
				if (type.conformsTo(clinicalDocument))
				{
					cdaDocuments.put(type.getQualifiedName(), type);
				}
			}
			
		}

	}
		
	
	
	}



	
}