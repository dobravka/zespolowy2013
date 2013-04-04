<%==SIM:Set:private=__==%>
<%==SIM:ForEach:Element.DocumentationLines==%>#<%==SIM:DocumentationLine==%>
<%==SIM:EndFor==%>class <%==SIM:Element.Name==%><%==SIM:If:Element.HasSuperClass==%>(<%==SIM:Element.SuperClass.Name==%>)<%==SIM:EndIf==%>:    
<%==SIM:ForEach:Element.Attributes==%>    <%==SIM:ForEach:Attribute.DocumentationLines==%>#<%==SIM:DocumentationLine==%>
    <%==SIM:EndFor==%><%==SIM:Attribute.Visibility==%><%==SIM:Attribute.Name==%> = <%==SIM:If:Attribute.HasDefaultValue==%><%==SIM:Attribute.DefaultValue==%><%==SIM:EndIf==%><%==SIM:IfNot:Attribute.HasDefaultValue==%>0<%==SIM:EndIf==%>
    assert(type(<%==SIM:Attribute.Visibility==%><%==SIM:Attribute.Name==%>)==<%==SIM:Attribute.Type==%>)
<%==SIM:EndFor==%>

<%==SIM:ForEach:Element.Operations==%>    <%==SIM:ForEach:Operation.DocumentationLines==%>#<%==SIM:DocumentationLine==%>
    <%==SIM:EndFor==%>def <%==SIM:Operation.Visibility==%><%==SIM:Operation.Name==%> (self<%==SIM:ForEach:Operation.Parameters==%>, <%==SIM:Parameter.Name==%><%==SIM:EndFor==%>):        
        # implementation
<%==SIM:EndFor==%>
