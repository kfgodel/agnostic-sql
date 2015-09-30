<#include "/macros/_renderAsModel.ftl"/>
<@compress single_line=true>
ALTER TABLE <@renderAsModel model=model.table/> RENAME TO ${model.newName}
</@compress>