        package com.example.mo9ata3a_project.repositories;
        import com.example.mo9ata3a_project.entities.Citoyen;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.stereotype.Repository;

        import java.util.List;
        import java.util.Map;
        import java.util.Optional;

        @Repository
        public interface CitoyenRepo extends JpaRepository<Citoyen, Long> {

                @Query("SELECT c.quartier as quartier, COUNT(c) as citoyenCount FROM Citoyen c GROUP BY c.quartier")
                public List<Map<String, Object>> getCitoyenCountByQuartier();


        }

