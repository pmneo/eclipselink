############################################################################
# Generic script applicable on any Operating Environments (Unix, Windows)
# ScriptName    : wls_reset.py
# Properties    : weblogic.properties
# Author        : Kevin Yuan
############################################################################

#===========================================================================
# Connect to wls server
#===========================================================================

connect('@WL_USR@','@WL_PWD@','t3://@WL_HOST@:@WL_PORT@')

#===========================================================================
# Remove Data Sources using wlst on-line commonds
#===========================================================================

edit()
startEdit()
delete('@DS_NAME@','JDBCSystemResource')
delete('@NON_JTA_DS_NAME@','JDBCSystemResource')
save()
activate()
exit()
