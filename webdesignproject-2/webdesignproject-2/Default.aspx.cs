using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class _Default : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void TextBox3_TextChanged(object sender, EventArgs e)
    {

    }

    protected void TextBox4_TextChanged(object sender, EventArgs e)
    {

    }
    protected void btnUpload_Click(object sender,EventArgs e)
    {
        string file_prefix = Server.MapPath("~/uploads/CV_" + Name.Text + DateTime.Now.ToString("ddMyyMhhmmss") + "_");
        if (CVFileUpload.HasFile)
        {
            string filename = file_prefix + CVFileUpload.FileName;

            CVFileUpload.SaveAs(filename);
            CVFileName.Text = filename;
        }
    }
         

    }
