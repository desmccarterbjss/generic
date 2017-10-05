:top

/^[ ]*\@PDAPTT\-.*$/{

	s/^.*\(PDAPTT\-[0-9]*\).*/\1/g

	h

	n

	/^[ ]*Scenario[^:]*:.*$/{

		s/^[ ]*Scenario[^:]*:[ ]*\(.*\)/\1/g

		G	
		p

	}

	b top
}


