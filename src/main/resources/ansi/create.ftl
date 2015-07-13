CREATE TABLE ${tableName} (
<#list tableParts as tablePart><#include "_tablePart.ftl"><#sep>, ${"\n"}</#sep></#list>
)