<#include "/macros/_renderAsModel.ftl" />
<@compress single_line=true>
INSERT INTO <@renderAsModel model=model.table/>
<#if model.hasColumnList >
${" "}( <#list model.columnList as column><@renderAsModel model=column/><#sep>, </#sep></#list> )
</#if>
${" "}<@renderAsModel model=model.valueDefinition/>
</@compress>