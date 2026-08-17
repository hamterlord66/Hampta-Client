package net.lax1dude.eaglercraft.v1_8;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiButton;

public class GuiShiftMenu extends GuiScreen {

    private boolean fullbrightEnabled = false;

    @Override
    public void initGui() {
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 2 - 20, "Fullbright: OFF"));
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == 0) {
            fullbrightEnabled = !fullbrightEnabled;
            button.displayString = "Fullbright: " + (fullbrightEnabled ? "ON" : "OFF");
            if (fullbrightEnabled) {
                mc.gameSettings.gammaSetting = 100.0f;
            } else {
                mc.gameSettings.gammaSetting = 1.0f;
            }
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, "My Custom Menu", this.width / 2, this.height / 2 - 60, 0xFFFFFF);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}