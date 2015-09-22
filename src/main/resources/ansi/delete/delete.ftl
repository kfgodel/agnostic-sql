<#include "/macros/_renderAsModel.ftl">
<@compress single_line=true>
DELETE FROM <@renderAsModel model=model.table/>
<#if model.whereClause.defined>
${" "}<@renderAsModel model=model.whereClause/>
</#if>
</@compress>