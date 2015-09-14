<#include "/macros/_renderAsModel.ftl"/>
<@compress single_line=true>
ALTER TABLE ${tableName} ADD <@renderAsModel model=columnDeclaration />
</@compress>