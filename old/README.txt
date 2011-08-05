NUXEO IDE
=========

Provides tools for Eclipse to help developing Nuxeo based software.

INSTALL FROM THE UPDATE SITE
----------------------------

Plugins can be retrieved from the update site. But it's aim to developers who
don't want to modified, debug nuxeo-ide (or simply don't want to run another
Eclipse in debug mode).

From Eclipse: 

- go to  help > software updates... > Available Software Tabs > Add Site... >

- then provide the url: http://download.nuxeo.org/nuxeo-ide/updates/snapshots/

- select "Nuxeo IDE Webengine Feature"

- and click "Install..."


CHECKOUT, IMPORT, BUILD and RUN
-------------------------------

From the sources:

$ hg clone http://hg.nuxeo.com/nuxeo-ide

Then in Eclipse: 

- File > Import > General > Existing Projects into Workspace
- Select the root folder of nuxeo-ide, and than all the projects.

Eclipse should build the project automatically.

To run it in debug mode: right click on org.nuxeo.ide.webengine > debug as an
Eclipse application.

WEBENGINE TOOLS
---------------

Webengine Nuxeo IDE provides a view called "Webengine server". This view is
composed of:

- Buttons to start/stop a webengine server (one in debug mode, the
  other in a normal mode).

- A refresh button, to refresh the list of module that has the
  "Webengine Nature" (see below).

- A preference button to set up the location of webengine. Normally,
  after having build webengine, a zip file is available containing
  the server. Unzip it somewhere and set the location in the preference
  dialog box.

- A button to open a internal webbrowser (currently to
  http://localhost:8080)

- A list of webengine module in to be include while debugging/running
  a server. Checked ones are going to be include. To add a webengine
  module in the list, right click on one of them in the workspace and
  click on "Nuxeo Tools > Add Webengine Nature", and refresh the list.
  Make sure that to remove from the bundles folder of your webengine
  all the modules that you check in this view, otherwise it will try
  to deploy it twice.


Have fun.

