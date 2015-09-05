# EROAD_VEHICLE_APP
A Sample application for displaying vehicle's localized timezone and datetime

This will read csv file say input.csv which contains UTC datetime, langitude and latitude information and then append the Timezone of Vehicle
and loclaized datetime in the output csv file. See below

input.csv

UTC datetime,Latitude,Longitude
2013-07-10 02:52:49,-44.490947,171.220966
2013-07-10 02:52:49,-33.912167,151.215820

Output.csv 

UTC datetime,Latitude,Longitude,Vehicle TimeZone,localised datetime
2013-07-10 02:52:49,-44.490947,171.220966,Pacific/Auckland,2013-07-10T14:52:49
2013-07-10 02:52:49,-33.912167,151.215820,Australia/Sydney,2013-07-10T12:52:49
