package mum.swe.mumsched.service;

import java.util.List;

import mum.swe.mumsched.model.Entry;

public interface EntryService {

	List<Entry> getList();

	Entry save(Entry entry);

	Entry findEntryById(Long id);

	void delete(Entry entry);

	boolean hasExistsEntryName(String name, long excludedId);

	boolean hasStudentRef(Entry entry);

	boolean hasScheduleRef(Entry entry);
}
