package com;

import com.rates.web.ForwardToFetch;

import com.rates.web.GiphyClient;
import com.rates.web.OxrClient;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableFeignClients(clients = {OxrClient.class, GiphyClient.class})
public class RatesGifsApplication {

	/** Приложение последовательно запрашивает данные с https://docs.openexchangerates.org и с https://giphy.com.
	 * Приложению не требуются указания пользователя, все нужные параметры уже прописаны в yml. При этом, заложена возможность доработать приложение для кастомизации запроса самим пользователем.
	 * Сразу после запуска приложение отправляет запрос на localhost, перехватываемый контролером. Далее веб-служба получает от остальных служб параметры и последовательно отправляет запросы на указанные сервисы.
	 * В самом конце используется веб-браузер для выдачи пользователю gif.
	 * Приложение самостоятельно открывает браузер и показывает польователю gif - если "app:mode=auto". В ином случае приложение выдаёт в командной строке ссылку на gif.
	 * Значения base и symbols используются в значении, определённом сервисом https://docs.openexchangerates.org.
	 * Помимо основных параметров в приложение (yml) добавлено дефолтное значение количества дней между датами первого и второго запроса курсов валют.
	 * Если оставить значение 1 (день), то вероятна ошибка при работе приложения сразу после смены дат, когда сервис выдачи курсов валют ещё не обновил данные. Либо для этого случая необходимо добавить логику выдачи более ранных курсов.
	 * */
	public static void main(String[] args) {

		SpringApplicationBuilder builder = new SpringApplicationBuilder(RatesGifsApplication.class);
		builder.headless(false);
		ConfigurableApplicationContext context = builder.run(args);
		ForwardToFetch.forwardToLocalHost();
	}
}