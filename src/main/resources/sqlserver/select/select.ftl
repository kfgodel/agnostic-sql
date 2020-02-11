<#include "/macros/_renderAsModel.ftl" />
<@compress single_line=true>
SELECT
<#if model.limit??>
${" "}TOP ${model.limit}
</#if>
${" "}<#list model.projections as projection><@renderAsModel model=projection/><#sep>, </#sep></#list>
<#if model.fromClause??>
${" "}<@renderAsModel model=model.fromClause />
</#if>
<#if model.whereClause.defined>
${" "}<@renderAsModel model=model.whereClause/>
</#if>
</@compress>