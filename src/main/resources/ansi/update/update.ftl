<#include "/macros/_renderAsModel.ftl">
<@compress single_line=true>
UPDATE ${tableName}
SET <#list columnAssignments as columnAssignment>
  <@renderAsModel model=columnAssignment />
  <#sep>, </#sep>
</#list>
<#if whereClause.defined>
${" "}<@renderAsModel model=whereClause/>
</#if>
</@compress>