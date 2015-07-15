CREATE TABLE ${tableName} (
<#list tableParts as tablePart><#include "/create/_tablePart.ftl"><#sep>, ${"\n"}</#sep></#list>
)