<#include "/macros/_renderAsModel.ftl"/>
<@compress single_line=true>
ALTER TABLE ${model.tableName} ADD CONSTRAINT ${model.constraint.name} <@renderAsModel model=model.constraint.declaration/>
</@compress>