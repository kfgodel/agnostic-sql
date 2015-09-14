<@compress single_line=true>
UPDATE ${tableName}
SET <#list columnAssignments as columnAssignment>
  <#include "${columnAssignment.templatePath}">
  <#sep>, </#sep>
</#list>
<#if whereClause.defined>
${" "}<#include "${whereClause.templatePath}" />
</#if>
</@compress>