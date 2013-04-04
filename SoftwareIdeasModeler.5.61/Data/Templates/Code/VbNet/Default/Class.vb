<%==SIM:Set:private=Private==%>
<%==SIM:Set:protected=Protected==%>
<%==SIM:Set:package=Friend==%>
<%==SIM:Set:public=Public==%>
<%==SIM:ForEach:Imports==%>
Imports <%==SIM:Import.Name==%>
<%==SIM:EndFor==%>

Namespace <%==SIM:Element.Namespace==%>
    <%==SIM:ForEach:Element.DocumentationLines==%>'<%==SIM:DocumentationLine==%>
    <%==SIM:EndFor==%><%==SIM:Element.Visibility==%> Class <%==SIM:Element.Name==%>
        <%==SIM:If:Element.HasSuperClass==%>Inherits <%==SIM:Element.SuperClass.Name==%><%==SIM:EndIf==%>
        <%==SIM:If:Element.HasInterfaces==%>Implements <%==SIM:ForEach:Element.Interfaces==%><%==SIM:Interface.Name==%><%==SIM:IfNot:IsLastItem==%>, <%==SIM:EndIf==%><%==SIM:EndFor==%><%==SIM:EndIf==%>

<%==SIM:ForEach:Element.Attributes==%>
        <%==SIM:ForEach:Attribute.DocumentationLines==%>'<%==SIM:DocumentationLine==%>
        <%==SIM:EndFor==%><%==SIM:Attribute.Visibility==%> <%==SIM:Attribute.Name==%> As <%==SIM:Attribute.Type==%><%==SIM:If:Attribute.HasDefaultValue==%> = <%==SIM:Attribute.DefaultValue==%><%==SIM:EndIf==%>
<%==SIM:EndFor==%>

<%==SIM:ForEach:Element.Operations==%>
        <%==SIM:ForEach:Operation.DocumentationLines==%>'<%==SIM:DocumentationLine==%>
        <%==SIM:EndFor==%><%==SIM:Operation.Visibility==%> <%==SIM:If:Operation.HasReturnType==%>Function<%==SIM:EndIf==%><%==SIM:IfNot:Operation.HasReturnType==%>Sub<%==SIM:EndIf==%> <%==SIM:Operation.Name==%> (<%==SIM:ForEach:Operation.Parameters==%><%==SIM:Parameter.Name==%> As <%==SIM:Parameter.Type==%><%==SIM:IfNot:IsLastItem==%>, <%==SIM:EndIf==%><%==SIM:EndFor==%>) <%==SIM:If:Operation.HasReturnType==%>As <%==SIM:Operation.ReturnType==%><%==SIM:EndIf==%>
            <%==SIM:Operation.SourceCodeBody==%>
        End <%==SIM:If:Operation.HasReturnType==%>Function<%==SIM:EndIf==%><%==SIM:IfNot:Operation.HasReturnType==%>Sub<%==SIM:EndIf==%>

<%==SIM:EndFor==%>
    End Class
End Namespace