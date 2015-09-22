<#include "/macros/_renderAsModel.ftl"/>
<@compress single_line=true>
ALTER TABLE <@renderAsModel model=model.table/> ADD CONSTRAINT ${model.constraint.name} <@renderAsModel model=model.constraint.declaration/>
</@compress>