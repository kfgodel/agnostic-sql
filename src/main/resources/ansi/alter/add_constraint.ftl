<#include "/macros/_renderAsModel.ftl"/>
<@compress single_line=true>
ALTER TABLE ${tableName} ADD CONSTRAINT ${constraint.name} <@renderAsModel model=constraint.declaration/>
</@compress>