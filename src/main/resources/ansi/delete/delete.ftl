<#include "/macros/_renderAsModel.ftl">
<@compress single_line=true>
DELETE FROM ${tableName}
<#if whereClause.defined>
${" "}<@renderAsModel model=whereClause/>
</#if>
</@compress>