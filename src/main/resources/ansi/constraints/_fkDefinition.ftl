<#include "/macros/_renderAsModel.ftl" />
FOREIGN KEY (
<#list model.columns as column>
  <@renderAsModel model=column/><#sep>, </#sep>
</#list>
) REFERENCES <@renderAsModel model=model.referencedTable/>