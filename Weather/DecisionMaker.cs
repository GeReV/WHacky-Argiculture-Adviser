using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Animaonline.Weather.WeatherData;

namespace Weather
{
    public class DecisionMaker
    {
        /// <summary>
        /// Get a recommendation (between 0-1) for irrigation.
        /// </summary>
        /// <param name="data">Weather data</param>
        /// <param name="dayOffset">Day on schedule. 0 for today, +1 for tomorrow, etc.</param>
        /// <returns>Number between 0 to 1 recommending irrigation (1 - irrigate, 0 - don't irrigate).</returns>
        public static float GetRecommendation(GoogleWeatherData data, int dayOffset)
        {
            int forecastLength = data.ForecastConditions.Count;

            if (dayOffset > forecastLength - 1 || dayOffset < 0)
            {
                throw new ArgumentOutOfRangeException("dayOffset");
            }

            float multiplier = 1.0f;
            if (CheckRainy(data.ForecastConditions[dayOffset].Condition))
            {
                multiplier = 0.05f;
            }
            else if ((dayOffset < forecastLength - 2 && dayOffset > 0))
            {
                if (CheckRainy(data.ForecastConditions[dayOffset + 1].Condition))
                {
                    multiplier = 0.2f;
                }
                else if (CheckRainy(data.ForecastConditions[dayOffset - 1].Condition))
                {
                    multiplier = 0.5f;
                }
                else if (data.ForecastConditions[dayOffset - 1].High.Celsius > 35 &&
                    data.ForecastConditions[dayOffset].High.Celsius > 35 &&
                    data.ForecastConditions[dayOffset + 1].High.Celsius > 35)
                {
                    multiplier = 1.4f;
                }
            }
            

            if ((int)data.ForecastInformation.ForecastDateTime.AddDays(dayOffset).DayOfWeek % 2 == 1)
            {
                return 0.8f * multiplier;
            }
            else
            {
                return 0.4f * multiplier;
            }
        }

        private static bool CheckRainy(string condition)
        {
            return condition.ToLowerInvariant().Contains("rain");
        }
    }
}