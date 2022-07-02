package net.nu11une.bobberbegone.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.render.entity.FishingBobberEntityRenderer.class)
public class FishingBobberEntityRendererMixin {
	@Inject(at = @At("HEAD"), method = "render(Lnet/minecraft/entity/projectile/FishingBobberEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V", cancellable = true)
	public void renderCallback(FishingBobberEntity fishingBobberEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
		PlayerEntity player = MinecraftClient.getInstance().player;
		if ((MinecraftClient.getInstance().options == null || MinecraftClient.getInstance().options.getPerspective().isFirstPerson()) && fishingBobberEntity.getHookedEntity() == player) {
			ci.cancel();
		}
	}
}
