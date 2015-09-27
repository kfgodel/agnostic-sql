<#include "/macros/_renderAsModel.ftl" />
DISTINCT <#list model.values as value><@renderAsModel model=value/><#sep>, </#sep></#list>