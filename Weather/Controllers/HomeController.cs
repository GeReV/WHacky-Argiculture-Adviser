using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Animaonline.Weather.WeatherData;
using Animaonline.Weather;

namespace Weather.Controllers
{
    public class HomeController : Controller
    {
        private const string latitude = "lat",
                                longitude = "long";
        public ActionResult Index()
        {
            float latitudeCoords = 0.0f, longitudeCoords = 0.0f;
            
            if (!float.TryParse(Request.QueryString[latitude], out latitudeCoords) || 
                !float.TryParse(Request.QueryString[longitude], out longitudeCoords))
            {
                return View("InvalidLocation");
            }

            ViewBag.MapImageUrl = string.Format("//maps.googleapis.com/maps/api/staticmap?center={0},{1}&zoom=16&size=400x400&maptype=satellite&sensor=true", latitudeCoords, longitudeCoords);

            GoogleWeatherData weather = Animaonline.Weather.GoogleWeatherAPI.GetWeather(Animaonline.Globals.LanguageCode.en_US, string.Format(",,,{0:00000000},{1:00000000}", latitudeCoords * 1e6, longitudeCoords * 1e6));
            //GoogleWeatherAPI.GetWeather(Animaonline.Globals.LanguageCode.en_US, );

            ViewBag.WeatherData = weather;

            return View();
        }

        public ActionResult About()
        {
            return View();
        }
    }
}
