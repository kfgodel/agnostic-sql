<@compress single_line=true>
DELETE FROM ${tableName}
<#if whereClause.defined>
${" "}<#include "${whereClause.templatePath}" />
</#if>
</@compress>