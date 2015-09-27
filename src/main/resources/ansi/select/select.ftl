<#include "/macros/_renderAsModel.ftl" />
SELECT <#list model.projections as projection><@renderAsModel model=projection/><#sep>, </#sep></#list><#rt>
<#if model.fromClause??>
${" "}<@renderAsModel model=model.fromClause /><#rt>
</#if>