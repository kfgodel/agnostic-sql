<#include "/macros/_renderAsModel.ftl" />
FROM <#list model.tableReferences as tableReference><@renderAsModel model=tableReference/><#sep>, </#sep></#list>