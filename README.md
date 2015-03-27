# Salesforce-Data-Export
A Salesforce Database Exporter using the Bulk API

Currently the packages needed to use this project are not included. To do this, go to https://www.salesforce.com/us/developer/docs/api_asynch/Content/asynch_api_code_set_up_client.htm and follow the directions.

# Changes the user needs to make:
  1. Change Username and Password in BulkMain.java to your username and login for your SFDC org.
  2. Change API version number in BulkMain.java if needed. Default is 29.0.
  3. Change first section of the bulkAuth url to the url of your org.

The default soapAuth string points to a sandbox for safety reasons. Change "test" to "login" if need be.
  
To run this program, you need to export it as a jar then have a file called input.txt in the same directory to run.
