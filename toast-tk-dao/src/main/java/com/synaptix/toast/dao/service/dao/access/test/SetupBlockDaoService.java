package com.synaptix.toast.dao.service.dao.access.test;

import javax.annotation.Nullable;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.name.Named;
import com.synaptix.toast.dao.domain.impl.test.block.SetupBlock;
import com.synaptix.toast.dao.service.dao.common.AbstractMongoDaoService;
import com.synaptix.toast.dao.service.dao.common.CommonMongoDaoService;
import com.synaptix.toast.dao.service.init.DbStarter;

public class SetupBlockDaoService extends AbstractMongoDaoService<SetupBlock> {

	public interface Factory {
		
		SetupBlockDaoService create(final @Nullable @Assisted String dbName);
	}

	@Inject
	public SetupBlockDaoService(
		final DbStarter starter,
		final CommonMongoDaoService cService,
		final @Nullable @Assisted String dbName,
		final @Named("default_db") String default_db
	) {
		super(SetupBlock.class, starter.getDatabaseByName((dbName == null ? default_db : dbName)), cService);
	}
}