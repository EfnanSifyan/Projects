<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <style type="text/css">
        .auto-style3 {
            font-family: Arial, Helvetica, sans-serif;
            font-style: italic;
            font-weight: bold;
            font-size: x-large;
            color: #660066;
        }
        .yeniStil1 {
            background-color: #339933;
        }
        .auto-style16 {
            background-color: #339933;
            height: 34px;
            width: 699px;
        }
        .yeniStil2 {
            background-color: #339933;
        }
        .yeniStil3 {
            font-size: large;
            font-weight: bold;
            color: #FFFFFF;
        }
        .auto-style18 {
            background-color: #339933;
            height: 26px;
            width: 699px;
        }
        .yeniStil4 {
            background-color: #339933;
        }
        .yeniStil5 {
            font-size: large;
        }
        .yeniStil6 {
            color: #FFFFFF;
            font-size: large;
        }
        .yeniStil7 {
            color: #FFFFFF;
            font-size: large;
        }
        .auto-style19 {
            background-color: #339933;
            width: 181px;
        }
        .yeniStil8 {
            color: #FFFFFF;
            font-size: large;
        }
        .yeniStil9 {
            font-size: large;
            color: #FFFFFF;
        }
        .yeniStil10 {
            font-size: large;
            color: #FFFFFF;
        }
        .yeniStil11 {
            font-size: large;
            color: #FFFFFF;
        }
        .yeniStil12 {
            font-size: large;
            color: #FFFFFF;
        }
        .yeniStil13 {
            font-size: large;
            color: #FFFFFF;
        }
        .yeniStil14 {
            font-size: large;
            color: #FFFFFF;
        }
        .yeniStil15 {
            font-size: large;
            color: #FFFFFF;
        }
        .yeniStil16 {
            background-color: #339966;
        }
        .auto-style21 {
            background-color: #339933;
            width: 181px;
            height: 24px;
        }
        .auto-style22 {
            background-color: #339933;
            height: 24px;
            width: 699px;
        }
        .auto-style23 {
            background-color: #339933;
            width: 699px;
        }
        .auto-style24 {
            width: 1230px;
            height: 728px;
        }
        .auto-style25 {
            background-color: #339933;
            width: 181px;
            height: 34px;
        }
        .auto-style26 {
            background-color: #339933;
            width: 181px;
            height: 26px;
        }
        .yeniStil17 {
            border-color: #339933;
        }
        .yeniStil18 {
            border-width: thin;
        }
        .auto-style27 {
            background-color: #339933;
            width: 181px;
            height: 119px;
        }
        .auto-style28 {
            background-color: #339933;
            width: 699px;
            height: 119px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div class="auto-style24">
            <br />
            <br />
            <span class="auto-style3">DO YOU WANT TO WORK WITH US?</span><br />
            <br />
            <br />
            <br />
            <table class="yeniStil18">
                <tr class="yeniStil5">
                    <td class="auto-style26" dir="auto"><span class="yeniStil6">Name and Surname</span></td>
                    <td class="auto-style18">
                        <asp:TextBox ID="Name" runat="server" Width="277px"></asp:TextBox>
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" BorderColor="Red" ErrorMessage="Name and Surname is required."></asp:RequiredFieldValidator>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style25"><span class="yeniStil7">City</span></td>
                    <td class="auto-style16">
                        <asp:DropDownList ID="DropDownList1" runat="server" AppendDataBoundItems="True" DataSourceID="contact" DataTextField="cityName" DataValueField="id">
                            <asp:ListItem Value="0">Select</asp:ListItem>
                        </asp:DropDownList>
                        <asp:SqlDataSource ID="contact" runat="server" ConnectionString="<%$ ConnectionStrings:ContactConnectionString %>" SelectCommand="SELECT [id], [cityName] FROM [city] ORDER BY [cityName]"></asp:SqlDataSource>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style26"><span class="yeniStil8">Country</span></td>
                    <td class="auto-style18">
                        <asp:DropDownList ID="DropDownList2" runat="server">
                        </asp:DropDownList>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style19"><span class="yeniStil9">E-Mail</span></td>
                    <td class="auto-style23">
                        <asp:TextBox ID="Email" runat="server" Height="19px" TextMode="Email" Width="277px"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style19"><span class="yeniStil10">Birth Date</span></td>
                    <td class="auto-style18">
                        <asp:TextBox ID="Birthdate" runat="server" OnTextChanged="TextBox3_TextChanged" TextMode="Date" Width="279px"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style19"><span class="yeniStil11">Phone Number</span></td>
                    <td class="auto-style23">
                        <asp:TextBox ID="Phonenumber" runat="server" OnTextChanged="TextBox4_TextChanged" TextMode="Phone" Width="281px"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style21"><span class="yeniStil12">Gender</span></td>
                    <td class="auto-style22">
                        <asp:RadioButtonList ID="RadioButtonList1" runat="server" ForeColor="White" RepeatDirection="Horizontal">
                            <asp:ListItem Value="M">Male</asp:ListItem>
                            <asp:ListItem Value="F">Female</asp:ListItem>
                        </asp:RadioButtonList>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style21"><span class="yeniStil13">Language</span></td>
                    <td class="auto-style22">
                        <asp:CheckBoxList ID="CheckBoxList1" runat="server" ForeColor="White" RepeatDirection="Horizontal">
                            <asp:ListItem Value="10">English</asp:ListItem>
                            <asp:ListItem Value="30">German</asp:ListItem>
                            <asp:ListItem Value="20">Spanish</asp:ListItem>
                            <asp:ListItem Value="40">Other</asp:ListItem>
                        </asp:CheckBoxList>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style27"><span class="yeniStil14">Message box</span></td>
                    <td class="auto-style28">
                        <asp:TextBox ID="messagebox" runat="server" Height="103px" TextMode="MultiLine" Width="309px"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style21"><span class="yeniStil15">Upload CV</span></td>
                    <td class="auto-style22">
                        <asp:FileUpload ID="CVFileUpload" runat="server" />
                        <asp:Button ID="btnUpload" runat="server" BackColor="#0066FF" BorderColor="White" Text="Upload" />
                    </td>
                </tr>
                <tr>
                    <td class="auto-style21">&nbsp;</td>
                    <td class="auto-style22">
                        <asp:TextBox ID="CVFileName" runat="server" Width="178px"></asp:TextBox>
                    </td>
                </tr>
            </table>
            <asp:Button ID="Button1" runat="server" BackColor="#66FF99" BorderColor="Black" CssClass="yeniStil16" Text="SEND" Width="142px" />
            <br />
            <br />
        </div>
    </form>
</body>
</html>
