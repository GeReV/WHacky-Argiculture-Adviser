using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Animaonline.Weather.WeatherData;

namespace Weather
{
    public class ForecastItem
    {
        public ForecastCondition Forecast { get; set; }
        public int Index { get; set; }
    }
}