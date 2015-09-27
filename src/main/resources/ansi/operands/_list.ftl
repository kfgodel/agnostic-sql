<#include "/macros/_renderAsModel.ftl" />
( <#list model.values as value><@renderAsModel model=value/><#sep>, </#sep></#list> )