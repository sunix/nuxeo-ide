Skinsoft Nuxeo IDE Uml contribution generator plug-in
-----------------------------------------------------


Nuxeo contributions are generated from uml files in the uml sub directories 
with the following file naming conventions :

Core type contributions are generated from Class Diagrams :

        * core-type.uml
        * core-type/*.uml

ECM type contributions are generated from Class Diagrams :

        * ecm-type.uml
        * ecm-type/*.uml

Actions and permissions contributions are generated from UseCase Diagrams :

        * actions.uml
        * actions/*.uml

Lifecycle contributions are generated from StateMachine Diagrams :

        * lifecycle.uml
        * lifecycle/*.uml

All uml contributions are generated to the src/main/resources.OSGI-INF/uml folder. 
They are added to the Nuxeo-Component: part of the MANIFEST.MF file.

Existing contributions referenced in the MANIFEST.MF are left unchanged (except for 
those lying in the OSGI-INF/uml folder).

XML Schemas are generated to the src/main/resources/schemas folder.

The project uml directory may contain a packager.properties file configuring the 
generation mechanism. For now, the only understood property is the 
generate.field.to.directory.associations boolean. When true, a contrib is generated 
for a skin-soft service enabling to link directories to xpaths.