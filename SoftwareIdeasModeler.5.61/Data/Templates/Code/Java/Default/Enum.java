package <%==SIM:Element.Namespace==%>;

<%==SIM:Set:private=private==%>
<%==SIM:Set:protected=protected==%>
<%==SIM:Set:package= ==%>
<%==SIM:Set:public=public==%>
<%==SIM:ForEach:Imports==%>
import <%==SIM:Import.Name==%>;
<%==SIM:EndFor==%>

<%==SIM:ForEach:Element.DocumentationLines==%>//<%==SIM:DocumentationLine==%>
<%==SIM:EndFor==%><%==SIM:Element.Visibility==%> enum <%==SIM:Element.Name==%>
{
<%==SIM:ForEach:Element.Attributes==%>
    <%==SIM:ForEach:Attribute.DocumentationLines==%>//<%==SIM:DocumentationLine==%>
    <%==SIM:EndFor==%><%==SIM:Attribute.Name==%>,
<%==SIM:EndFor==%>
}
