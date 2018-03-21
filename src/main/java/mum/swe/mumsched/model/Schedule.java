package mum.swe.mumsched.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import mum.swe.mumsched.enums.ScheduleStatusEnum;

@Entity
@Table(name="schedule")
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,property="id")
public class Schedule {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Enumerated
    @Column(columnDefinition = "smallint")
	private ScheduleStatusEnum status;
	
	//@JsonIgnore
	@OneToOne
	private Entry entry;
	
	//@JsonIgnore
	@OneToMany(mappedBy="schedule", cascade=CascadeType.ALL)
	private Set<Block> blockList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ScheduleStatusEnum getStatus() {
		return status;
	}

	public void setStatus(ScheduleStatusEnum status) {
		this.status = status;
	}

	public Entry getEntry() {
		return entry;
	}

	public void setEntry(Entry entry) {
		this.entry = entry;
	}

	public Set<Block> getBlockList() {
		return blockList;
	}

	public void setBlockList(Set<Block> blockList) {
		this.blockList = blockList;
	}
	
	public List<BlockSimple> getBlockSimple(){	
		List<BlockSimple> blocks = new ArrayList<BlockSimple>();
		Set<Block> blockList = this.getBlockList().stream().sorted(Comparator.comparing(Block::getId)).collect(Collectors.toSet());
		
		for(Block b : blockList) {
			String result = "";
			Set<Section> ss = b.getSectionList();
			BlockSimple bl = new BlockSimple();
			bl.setMonth(b.getMonth());
		    for(Section s: ss) {
		    	Course c = s.getCourse();
		    	Faculty f = s.getFaculty();
		    	result += c.getCode() + " " + c.getName() + " - " + f.getUser().getFullname() + "\n" ;
		    }
		    bl.setCourseName(result);
		    blocks.add(bl);
		}
		return blocks;
	}
}
