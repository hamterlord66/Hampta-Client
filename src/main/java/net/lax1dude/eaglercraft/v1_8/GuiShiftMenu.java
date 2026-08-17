package net.lax1dude.eaglercraft.v1_8;

import net.lax1dude.eaglercraft.v1_8.minecraft.GuiScreen;
import net.lax1dude.eaglercraft.v1_8.opengl.GlStateManager;
import net.minecraft.client.gui.GuiButton;
import java.io.IOException;

public class GuiShiftMenu extends GuiScreen {

    private boolean fullbrightEnabled = false;

    @Override
    public void initGui() {
        this.buttonList.clear();
        // Button to toggle Fullbright
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 2 - 20, "Fullbright: OFF"));
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 0) {
            fullbrightEnabled = !fullbrightEnabled;
            button.displayString = "Fullbright: " + (fullbrightEnabled ? "ON" : "OFF");
            // Apply the Fullbright effect
            if (fullbrightEnabled) {
                mc.gameSettings.gammaSetting = 100.0f; // Enable Fullbright
            } else {
                mc.gameSettings.gammaSetting = 1.0f; // Reset to normal brightness
            }
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, "Shift Menu", this.width / 2, this.height / 2 - 60, 0xFFFFFF);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false; // Menu does not pause the game
    }
}
