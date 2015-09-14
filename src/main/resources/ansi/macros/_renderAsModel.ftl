<#--Esta macro no sólo renderiza el modelo con su template correspondiente
  Si no que además permite redefinir localmente la variable model en cada
  template-->
<#macro renderAsModel model>
  <#include "${model.templatePath}">
</#macro>