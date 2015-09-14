<#include "/macros/_renderAsModel.ftl" />
<@compress single_line=true>
INSERT INTO ${tableName} (
<#list columnAssignments as columnAssignment>
${columnAssignment.columnName}<#sep>, </#sep>
</#list>
) VALUES (
<#list columnAssignments as columnAssignment>
<@renderAsModel model=columnAssignment.assignedValue /><#sep>, </#sep>
</#list>
)
</@compress>