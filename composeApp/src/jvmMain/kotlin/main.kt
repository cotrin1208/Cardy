import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.cotrin.cardy.Test
import org.jetbrains.skiko.MainUIDispatcher
import java.awt.Dimension

actual val dispatcher = MainUIDispatcher

fun main() {
	application {
		Window(
			title = "Cardy",
			state = rememberWindowState(width = 800.dp, height = 600.dp),
			onCloseRequest = ::exitApplication,
		) {
			window.minimumSize = Dimension(350, 600)
			Test()
		}
	}
}
