package org.example.lab4

import javafx.application.Application
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.control.TextInputDialog
import javafx.stage.Stage

class WeaponGUI : Application() {
    private val armory: Armory = Armory()

    @FXML
    private lateinit var displayLabel: Label

    override fun start(primaryStage: Stage) {
        primaryStage.title = "Weapon Arsenal"

        val fxmlLoader = FXMLLoader(javaClass.getResource("/org/example/lab4/weapon_gui.fxml"))
        fxmlLoader.setController(this)
        val root: Parent = fxmlLoader.load()
        val scene = Scene(root, 700.0, 700.0)
        primaryStage.scene = scene
        primaryStage.show()

        updateDisplay()
    }


    @FXML
    private fun addFirearmButtonClicked() {
        val firearmName = showInputDialog("Введите название огнестрельного оружия:")
        val barrelLength = showInputDialog("Введите длину ствола:")
        val range = showInputDialog("Введите дальность:")
        armory.addWeapon(Firearm(firearmName, barrelLength.toDouble(), range.toInt()))
        updateDisplay()
    }


    @FXML
    private fun addMeleeWeaponButtonClicked() {
        val weaponName = showInputDialog("Введите название холодного оружия:")
        val bladeLength = showInputDialog("Введите длину клинка:")
        val sharpness = showInputDialog("Введите заточку:")
        val attackType = showInputDialog("Введите тип атаки:")
        armory.addWeapon(ColdWeapon(weaponName, bladeLength.toDouble(), sharpness, attackType))
        updateDisplay()
    }

    @FXML
    private fun displayContentButtonClicked() {
        displayLabel.text = armory.getArsenalInfo()
    }

    private fun updateDisplay() {
        displayLabel.text = armory.getArsenalInfo()
    }

    private fun showInputDialog(prompt: String): String {
        val dialog = TextInputDialog()
        dialog.title = "Ввод данных"
        dialog.headerText = prompt
        val result = dialog.showAndWait()
        return result.orElse("")
    }

}

fun main() {
    Application.launch(WeaponGUI::class.java)
}
