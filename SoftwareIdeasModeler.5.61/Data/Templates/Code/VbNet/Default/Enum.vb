<%==SIM:Set:private=Private==%>
<%==SIM:Set:protected=Protected==%>
<%==SIM:Set:package=Friend==%>
<%==SIM:Set:public=Public==%>
<%==SIM:ForEach:Imports==%>
Imports <%==SIM:Import.Name==%>
<%==SIM:EndFor==%>

Namespace <%==SIM:Element.Namespace==%>
    <%==SIM:ForEach:Element.DocumentationLines==%>'<%==SIM:DocumentationLine==%>
    <%==SIM:EndFor==%><%==SIM:Element.Visibility==%> Enum <%==SIM:Element.Name==%>

<%==SIM:ForEach:Element.Attributes==%>
	    <%==SIM:Attribute.Name==%> <%==SIM:If:Attribute.HasDefaultValue==%> = <%==SIM:Attribute.DefaultValue==%><%==SIM:EndIf==%>
<%==SIM:EndFor==%>

    End Enum
End Namespace