############################################################################
# Generic script applicable on any Operating Environments (Unix, Windows)
# ScriptName    : wls_install.py
# Properties    : weblogic.properties test.properties
# Author        : Kevin Yuan
############################################################################

#===========================================================================
# Open a domain template.
#===========================================================================

try:
   readTemplate("@WL_HOME@/common/templates/wls/wls.jar")
except:
   readTemplate("@WL_HOME@/common/templates/domains/wls.jar")

#===========================================================================
# Configure the Administration Server and SSL port.
#===========================================================================

cd('Servers/AdminServer')
set('Name','@TARGET_SERVER@')
set('ListenAddress','@WL_HOST@')
set('ListenPort', @WL_PORT@)

create('AdminServer','SSL')
cd('SSL/AdminServer')
set('Enabled', 'True')
set('ListenPort', @WL_PORT_SSL@)

#===========================================================================
# Define the user password for weblogic.
#===========================================================================

cd('/')
cd('Security/base_domain/User/weblogic')
set('Name','@WL_USR@')
cmo.setPassword('@WL_PWD@')

#===========================================================================
# Write the domain and close the domain template.
#===========================================================================

setOption('OverwriteDomain', 'true')
writeDomain('@WL_DOMAIN@')
closeTemplate()

#===========================================================================
# Exit WLST.
#===========================================================================

exit()
