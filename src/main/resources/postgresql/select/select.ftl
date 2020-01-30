<#include "/macros/_renderAsModel.ftl" />
<@compress single_line=true>
SELECT <#list model.projections as projection><@renderAsModel model=projection/><#sep>, </#sep></#list>
<#if model.fromClause??>
${" "}<@renderAsModel model=model.fromClause />
</#if>
<#if model.whereClause.defined>
${" "}<@renderAsModel model=model.whereClause/>
</#if>
<#if model.limit??>
    ${" "} limit ${model.limit}
</#if>
</@compress>