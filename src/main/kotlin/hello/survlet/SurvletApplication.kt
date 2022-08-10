package hello.survlet

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletComponentScan

@ServletComponentScan
@SpringBootApplication
class SurvletApplication

fun main(args: Array<String>) {
    runApplication<SurvletApplication>(*args)
}
