package io.github.bubblie01.haunted_pants;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

public class ClientInitializer implements ClientModInitializer {

	public void onInitializeClient(ModContainer mod) {

		EntityRendererRegistry.register(HauntedPantsEntity.PANT_ENTITY_TYPE, ((context) -> {
			return new HauntedPantsEntityRenderer(context);
		}));
	}
}
