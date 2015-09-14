<#include "/macros/_renderAsModel.ftl">
<@compress single_line=true>
DELETE FROM ${model.tableName}
<#if model.whereClause.defined>
${" "}<@renderAsModel model=model.whereClause/>
</#if>
</@compress>