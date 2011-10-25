using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

public static class HtmlHelperExtensions
{
    public static MvcHtmlString Image(this HtmlHelper html, string imagePath, string alt = "")
    {
        var url = new UrlHelper(html.ViewContext.RequestContext);

        // build the <img> tag
        var imgBuilder = new TagBuilder("img");
        imgBuilder.MergeAttribute("src", url.Content(imagePath));
        imgBuilder.MergeAttribute("alt", alt);
        string imgHtml = imgBuilder.ToString(TagRenderMode.SelfClosing);

        return MvcHtmlString.Create(imgHtml);
    }
}